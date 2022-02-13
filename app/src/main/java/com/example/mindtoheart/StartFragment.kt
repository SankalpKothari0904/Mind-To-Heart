package com.example.mindtoheart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mindtoheart.databinding.FragmentStartBinding
import com.example.mindtoheart.model.QuestionViewModel

class StartFragment : Fragment() {
    private var binding: FragmentStartBinding?=null
    private val sharedViewModel: QuestionViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding= FragmentStartBinding.inflate(inflater, container, false)
        binding=fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply{
            viewModel=sharedViewModel
            lifecycleOwner= viewLifecycleOwner
            startFragment= this@StartFragment
        }
    }

    fun goToNextScreen(){
        if (sharedViewModel.hasNoWorkSet()){
            sharedViewModel.setWorkOrAcads(getString(R.string.working))
        }
        if (sharedViewModel.hasNoRelationSet()){
            sharedViewModel.setRelationship(getString(R.string.committed))
        }
        findNavController().navigate(R.id.action_startFragment_to_inputFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}