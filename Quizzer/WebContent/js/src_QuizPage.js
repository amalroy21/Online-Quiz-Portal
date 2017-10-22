var score =new Array();
score[0]=0;
var maxQns=5;
var questionlist=new Array();
var timer=600;
var min=0;
var sec=0;
var jsonQuestionObj=new Object();
var max_questions=5;
var questionCounter=0;
var qlevel=1;
var compid=1;

$(document).ready(function () {
	
	startTimer();
	
});

function populateQuestions(list_questions){
	
	var questionObj=JSON.parse(list_questions);
	jsonQuestionObj=questionObj;
	console.log(questionObj);
	if(jsonQuestionObj.length>0){
		displayQuiz(++questionCounter);
	}
	maxQns=jsonQuestionObj.length;
}


function displayQuiz(question_no){
	var n=question_no-1;
	if(question_no>0 && jsonQuestionObj[n]!=undefined){
		document.getElementById('PopQuiz').style.display="block";
			$('#questionNo').val(question_no);
			$('#Qns').text(jsonQuestionObj[n].question);
			$('#OptA').text(jsonQuestionObj[n].optionA);
			$('#OptB').text(jsonQuestionObj[n].optionB);
			$('#OptC').text(jsonQuestionObj[n].optionC);
			$('#OptD').text(jsonQuestionObj[n].optionD);
			$('#correctAns').val(jsonQuestionObj[n].answer);
			score[question_no]=0;
			if(maxQns==n+1){
				$('#submit').val("Finish");
			}
			document.getElementById("no_qn").innerHTML = "<b> Question no </b>"+question_no+"/"+maxQns;
			
	}else{
		showscore();
	}
}

function checkSolution(){
	
	var opt=$("input[name='a']:checked"). val();
	var ans=$('#correctAns').val();
	var qn=$('#questionNo').val();
	if(opt==undefined || ans==undefined){
		alert("Please choose an option.");
		return;
	}
	$("input[name='a']").attr('checked', false)
	if(opt.toUpperCase()==ans.toUpperCase()){
		score[qn]=1;
	}
	document.getElementById('PopQuiz').style.display="none";
    displayQuiz(++questionCounter);
    
}

function startTimer(){
	min=parseInt(timer/60);
	sec=parseInt(timer%60);

	if(timer<1){
		alert("Times Up!");
		showscore();
    }
		
	document.getElementById("time").innerHTML = "<b> Time Left: </b>"+min.toString()+":"+sec.toString() +" mins";
	timer--;
	setTimeout(function(){ startTimer(); }, 1000);
}
function showscore(){
	
	var i=0;
	var result=0;
	score[0]=0;
	score.forEach(function(x){
		i++;
		result+=x;
	});
	var msg="Succesfull completion!";
	 $.ajax({
         type: "POST",
         url: "ResultController", 
         data: {score:result,qnlevel:qlevel,companyid:compid,total:max_questions},
         success: function(msg){

             alert(msg);
         },
         error: function(){
             alert("Quiz was not completed successfully.");
         }
     });
	
	window.location="Result.jsp?score="+result;
}