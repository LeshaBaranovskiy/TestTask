package com.example.empattesttask.presentation.dialog

import android.app.Dialog
import android.content.Context

class DialogBuilder {
    companion object {
        fun buildFromDbWarningDialog(
            context: Context,
            okBtnClick: () -> Unit
        ): FromDbWarningDialog {
            val fromDbWarningDialog =
                FromDbWarningDialog(context, okBtnClick)
            fromDbWarningDialog.setCancelable(true)
            return fromDbWarningDialog
        }
    }
}