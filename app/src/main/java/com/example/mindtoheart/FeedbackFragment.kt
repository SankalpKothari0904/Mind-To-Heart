package com.example.mindtoheart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mindtoheart.adapter.FeedbackAdapter
import com.example.mindtoheart.data.Feedback
import com.example.mindtoheart.databinding.FragmentFeedbackBinding
import com.example.mindtoheart.databinding.FragmentInputBinding
import com.example.mindtoheart.model.QuestionViewModel

class FeedbackFragment : Fragment() {
    private var binding: FragmentFeedbackBinding?=null
    private val sharedViewModel: QuestionViewModel by activityViewModels()
    private lateinit var recyclerView:RecyclerView
    private lateinit var dataset: List<Feedback>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding= FragmentFeedbackBinding.inflate(inflater, container, false)
        binding=fragmentBinding
        Log.d("App flow", "Feedback fragment started")
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply{
            viewModel=sharedViewModel
            lifecycleOwner= viewLifecycleOwner
            feedbackFragment= this@FeedbackFragment
        }

        Log.d("App flow","Feedback Fragment Created")
        dataset=sharedViewModel.setFeedbackDataSource()
        recyclerView= binding?.recyclerView!!
        recyclerView.adapter= FeedbackAdapter(requireContext(),dataset)
    }

    fun goToHome(){
        findNavController().navigate(R.id.action_feedbackFragment_to_startFragment)
        sharedViewModel.reset()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}