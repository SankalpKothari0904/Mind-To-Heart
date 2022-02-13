package com.example.mindtoheart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mindtoheart.databinding.FragmentInputBinding
import com.example.mindtoheart.model.QuestionViewModel


class InputFragment : Fragment() {
    private var binding: FragmentInputBinding?=null
    private val sharedViewModel: QuestionViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding= FragmentInputBinding.inflate(inflater, container, false)
        binding=fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply{
            viewModel=sharedViewModel
            lifecycleOwner= viewLifecycleOwner
            inputFragment= this@InputFragment
        }
    }

    fun goToNextScreen(){
        sharedViewModel.setDatasource()
        sharedViewModel.setCount()
        sharedViewModel.extractQuestion()
        findNavController().navigate(R.id.action_inputFragment_to_questionsFragment)
    }

}