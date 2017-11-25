package com.example.nishantsikri.microdoctor;

/**
 * Created by nishantsikri on 8/11/17.
 */

public class Symptom {

    public String symptom1;
    public String symptom2;
    public String symptom3;
    public String disease;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Symptom(){

    }
    public  Symptom(String symptom1, String symptom2, String symptom3, String disease){
        this.symptom1 = symptom1;
        this.symptom2 = symptom2;
        this.symptom3 = symptom3;
        this.disease = disease;
    }

    public String getDisease(){
        return disease;
    }
    public void setDisease(String disease){
        this.disease=disease;
    }
}
