package com.example.mindtoheart


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mindtoheart.databinding.FragmentQuestionsBinding
import com.example.mindtoheart.model.QuestionViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class QuestionsFragment : Fragment() {
    private lateinit var binding: FragmentQuestionsBinding
    private val sharedViewModel: QuestionViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_questions, container, false)
        Log.d("App flow","Question fragment started")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            viewModel=sharedViewModel
            lifecycleOwner= viewLifecycleOwner
            questionFragment= this@QuestionsFragment
        }
        Log.d("App flow","Question fragment created")
    }


    private fun goToNextScreen(){
        findNavController().navigate(R.id.action_questionsFragment_to_feedbackFragment)
        Log.d("App flow", "Go to next screen successful")
    }

    private fun showEndDialog(){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.end_quiz))
            .setMessage(getString(R.string.end_message))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.get_results)){ _, _ -> goToNextScreen()}
            .show()
    }

    fun submitQuestion(){
        sharedViewModel.updateQuestionCount()
        if (sharedViewModel.questionCount.value!! < 25) {
            sharedViewModel.updateScore()
            sharedViewModel.extractQuestion()
        }else{
            showEndDialog()
        }
    }

}