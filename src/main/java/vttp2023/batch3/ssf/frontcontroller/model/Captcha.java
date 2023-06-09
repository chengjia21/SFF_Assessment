package vttp2023.batch3.ssf.frontcontroller.model;

public class Captcha {

    private Double randNum1;
    private Double randNum2;
    private String operator;

    private Double answer;
    private Double userInput;
    private boolean isCorrect;


    private boolean checkCaptcha(String operator, Double randNum1, Double randNum2){
    switch (operator){
        case "+":
        answer = randNum1 + randNum2;
        if(userInput == answer){return isCorrect == true;}
            break;
        case "-":
        answer = randNum1 - randNum2;  
        if(userInput == answer){return isCorrect == true;}
            break;
        case "*":
        answer = randNum1 * randNum2;   
        if(userInput == answer){return isCorrect == true;}
            break;
        case "/":
        answer = randNum1 / randNum2;    
        if(userInput == answer){return isCorrect == true;}
            break;

            default: return isCorrect==false;
            




    }
    return isCorrect;
    }
}


