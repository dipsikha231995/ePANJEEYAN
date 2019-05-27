package ePanjeeyanModel;

public class DeedCategoryModel {
    
   //declare member variables
    private int code;
    private String section;
    
    public DeedCategoryModel(int code, String section){
        this.code = code;
        this.section = section;   
    }
    
    //define getter method
    public int getCode() {
        return this.code;
    }

    public String getSection() {
        return this.section;
    }

    
    //String represention of an object
    @Override
    public String toString() {
        return "DeedCategoryModel{" + "code=" + code + ", section=" + section + '}';
    }
       
    
}
