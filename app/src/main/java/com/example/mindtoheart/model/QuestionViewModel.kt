package com.example.mindtoheart.model

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mindtoheart.R
import com.example.mindtoheart.data.*

class QuestionViewModel:ViewModel() {

    private var workOrAcadScore: Int =0
    private var relationshipScore:Int =0
    private var peerScore:Int =0
    private var internetScore:Int =0
    private var selfLoveScore:Int =0

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _workOrAcads= MutableLiveData<String>()
    val workOrAcads: LiveData<String> = _workOrAcads

    private val _relationshipStatus= MutableLiveData<String>()
    val relationshipStatus: LiveData<String> = _relationshipStatus

    private val _currentQuestionScore = MutableLiveData<Int>()
    val currentQuestionScore: LiveData<Int> = _currentQuestionScore

    private val _questionCount= MutableLiveData<Int>()
    val questionCount:LiveData<Int> = _questionCount

    private lateinit var dataset: List<questions>

    private val _question= MutableLiveData<questions>()
    private val _option1= MutableLiveData<Int>()
    private val _option2= MutableLiveData<Int>()
    private val _option3= MutableLiveData<Int>()
    private val _option4= MutableLiveData<Int>()
    private val _image= MutableLiveData<Int>()
    val option1:LiveData<Int> = _option1
    val option2:LiveData<Int> = _option2
    val option3:LiveData<Int> = _option3
    val option4:LiveData<Int> = _option4
    val image:LiveData<Int> = _image

    private val _questionText= MutableLiveData<Int>()
    val questionText:LiveData<Int> = _questionText


    fun setRelationship(relationshipstatus: String){
        _relationshipStatus.value = relationshipstatus
    }

    fun setWorkOrAcads(workStatus: String){
        _workOrAcads.value = workStatus
    }

    fun hasNoRelationSet():Boolean{
        return _relationshipStatus.value.isNullOrEmpty()
    }
    fun hasNoWorkSet():Boolean{
        return _workOrAcads.value.isNullOrEmpty()
    }

    fun setDatasource(){

        if (_workOrAcads.value== "Working" && _relationshipStatus.value== "In a relationship"){
            dataset= Datasource_work_relation().loadQuestions()
        }
        else if(_workOrAcads.value== "Working" && _relationshipStatus.value== "Single"){
            dataset= Datasource_work_single().loadQuestions()
        }
        else if(_workOrAcads.value== "Student" && _relationshipStatus.value== "In a relationship"){
            dataset= Datasource_acad_relation().loadQuestions()
        }
        else if(_workOrAcads.value== "Student" && _relationshipStatus.value== "Single"){
            dataset= Datasource_acad_single().loadQuestions()
        }
        Log.d("App flow","Set Datasource successful")
    }
    fun setCount(){
        _questionCount.value= 0
        Log.d("App flow","Set count successful")
    }

    fun extractQuestion(){
        _question.value= dataset[_questionCount.value!!]
        _option1.value= _question.value!!.option1.stringResourceId
        _option2.value= _question.value!!.option2.stringResourceId
        _option3.value= _question.value!!.option3.stringResourceId
        _option4.value= _question.value!!.option4.stringResourceId
        _questionText.value= _question.value!!.questionStringResourceId
        _image.value= _question.value!!.imageResourceId
        Log.d("App flow","Extract Question successful")
    }


    fun updateQuestionCount(){
        _questionCount.value=(_questionCount.value)?.plus(1)
    }

    fun setCurrentQuestionScore(score: Int){
        _currentQuestionScore.value= score
    }

    fun updateScore(){
        if (_questionCount.value!! <5){
            workOrAcadScore+=_currentQuestionScore.value!!
        }
        else if((_questionCount.value!! <10) && (_questionCount.value!! >4)){
            relationshipScore+=_currentQuestionScore.value!!
        }
        else if((_questionCount.value!! <15) && (_questionCount.value!! >9)){
            peerScore+=_currentQuestionScore.value!!
        }
        else if ((_questionCount.value!! <20) && (_questionCount.value!! >14)){
            internetScore+=_currentQuestionScore.value!!
        }
        else if ((_questionCount.value!! <25) && (_questionCount.value!! >19)){
            selfLoveScore+=_currentQuestionScore.value!!
        }
    }

    fun setFeedbackDataSource():MutableList<Feedback>{
        val feedbackList= mutableListOf<Feedback>()
        if (workOrAcadScore in 0..3 && _workOrAcads.value=="Working"){
            feedbackList.add(Feedback(R.string.feedback_work_range1, R.drawable.feedback_work))
        }
        else if (workOrAcadScore in 4..7 && _workOrAcads.value=="Working"){
            feedbackList.add(Feedback(R.string.feedback_work_range2, R.drawable.feedback_work))
        }
        else if (workOrAcadScore in 8..11 && _workOrAcads.value=="Working"){
            feedbackList.add(Feedback(R.string.feedback_work_range3, R.drawable.feedback_work))
        }
        else if (workOrAcadScore in 12..15 && _workOrAcads.value=="Working"){
            feedbackList.add(Feedback(R.string.feedback_work_range4, R.drawable.feedback_work))
        }
        else if (workOrAcadScore in 0..3 && _workOrAcads.value=="Student"){
            feedbackList.add(Feedback(R.string.feedback_academics_range1, R.drawable.feedback_study))
        }
        else if (workOrAcadScore in 4..7 && _workOrAcads.value=="Student"){
            feedbackList.add(Feedback(R.string.feedback_academics_range2, R.drawable.feedback_study))
        }
        else if (workOrAcadScore in 8..11 && _workOrAcads.value=="Student"){
            feedbackList.add(Feedback(R.string.feedback_academics_range3, R.drawable.feedback_study))
        }
        else {
            feedbackList.add(Feedback(R.string.feedback_academics_range4, R.drawable.feedback_study))
        }

        if (relationshipScore in 0..3 && _relationshipStatus.value=="In a relationship"){
            feedbackList.add(Feedback(R.string.feedback_committed_range1, R.drawable.feedback_relationship))
        }
        else if (relationshipScore in 4..7 && _relationshipStatus.value=="In a relationship"){
            feedbackList.add(Feedback(R.string.feedback_committed_range2, R.drawable.feedback_relationship))
        }
        else if (relationshipScore in 8..11 && _relationshipStatus.value=="In a relationship"){
            feedbackList.add(Feedback(R.string.feedback_committed_range3, R.drawable.feedback_relationship))
        }
        else if (relationshipScore in 12..15 && _relationshipStatus.value=="In a relationship"){
            feedbackList.add(Feedback(R.string.feedback_committed_range4, R.drawable.feedback_relationship))
        }
        else if (relationshipScore in 0..3 && _relationshipStatus.value=="Single"){
            feedbackList.add(Feedback(R.string.feedback_single_range1, R.drawable.feedback_single))
        }
        else if (relationshipScore in 4..7 && _relationshipStatus.value=="Single"){
            feedbackList.add(Feedback(R.string.feedback_single_range2, R.drawable.feedback_single))
        }
        else if (relationshipScore in 8..11 && _relationshipStatus.value=="Single"){
            feedbackList.add(Feedback(R.string.feedback_single_range3, R.drawable.feedback_single))
        }
        else {
            feedbackList.add(Feedback(R.string.feedback_single_range4, R.drawable.feedback_single))
        }

        when (peerScore) {
            in 0..3 -> {
                feedbackList.add(Feedback(R.string.feedback_peer_range1, R.drawable.feedback_peer))
            }
            in 4..7 -> {
                feedbackList.add(Feedback(R.string.feedback_peer_range2, R.drawable.feedback_peer))
            }
            in 8..11 -> {
                feedbackList.add(Feedback(R.string.feedback_peer_range3, R.drawable.feedback_peer))
            }
            else -> {
                feedbackList.add(Feedback(R.string.feedback_peer_range4, R.drawable.feedback_peer))
            }
        }

        when (internetScore) {
            in 0..3 -> {
                feedbackList.add(Feedback(R.string.feedback_internet_range1, R.drawable.feedback_internet))
            }
            in 4..7 -> {
                feedbackList.add(Feedback(R.string.feedback_internet_range2, R.drawable.feedback_internet))
            }
            in 8..11 -> {
                feedbackList.add(Feedback(R.string.feedback_internet_range3, R.drawable.feedback_internet))
            }
            else -> {
                feedbackList.add(Feedback(R.string.feedback_internet_range4, R.drawable.feedback_internet))
            }
        }

        when (selfLoveScore) {
            in 0..3 -> {
                feedbackList.add(Feedback(R.string.feedback_self_love_range1, R.drawable.feedback_self_love))
            }
            in 4..7 -> {
                feedbackList.add(Feedback(R.string.feedback_self_love_range2, R.drawable.feedback_self_love))
            }
            in 8..11 -> {
                feedbackList.add(Feedback(R.string.feedback_self_love_range3, R.drawable.feedback_self_love))
            }
            else -> {
                feedbackList.add(Feedback(R.string.feedback_self_love_range4, R.drawable.feedback_self_love))
            }
        }

        return feedbackList
    }

    fun reset(){
        workOrAcadScore=0
        relationshipScore=0
        peerScore=0
        internetScore=0
        selfLoveScore=0
        _workOrAcads.value="Working"
        _relationshipStatus.value="In a relationship"
        _name.value=""
        _questionCount.value=0
        _currentQuestionScore.value=0
    }

}