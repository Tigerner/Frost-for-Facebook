package com.pitchedapps.frost.enums

import android.content.Context
import android.support.annotation.StringRes
import ca.allanwang.kau.email.sendEmail
import ca.allanwang.kau.utils.string
import com.pitchedapps.frost.R
import com.pitchedapps.frost.utils.Prefs
import com.pitchedapps.frost.utils.iab.IS_FROST_PRO

/**
 * Created by Allan Wang on 2017-06-29.
 */
enum class Support(@StringRes val title: Int) {
    FEEDBACK(R.string.feedback),
    BUG(R.string.bug_report),
    THEME(R.string.theme_issue),
    FEATURE(R.string.feature_request);

    fun sendEmail(context: Context) {
        with(context) {
            this.sendEmail(string(R.string.dev_email), "${string(R.string.frost_prefix)} ${string(title)}") {
                val proTag = if (IS_FROST_PRO) "TY" else "FP"
                addItem("Random Frost ID", "${Prefs.frostId}-$proTag")
            }
        }
    }
}