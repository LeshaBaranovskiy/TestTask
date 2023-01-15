package com.example.empattesttask.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import com.example.empattesttask.R
import com.example.empattesttask.databinding.DialogFromDbWarningBinding

class FromDbWarningDialog(
    context: Context,
    private val okBtnClick: () -> Unit
): Dialog(context, R.style.Dialog) {
    private var _binding: DialogFromDbWarningBinding? = null
    private val binding get() = _binding!!

    init {
        _binding = DialogFromDbWarningBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.dialogBtnOk.setOnClickListener {
            okBtnClick.invoke()
        }
    }
}