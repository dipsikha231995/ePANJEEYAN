package ePanjeeyanDAO;

import ePanjeeyanModel.DeedCategoryModel;
import java.util.List;

public interface DeedCategoryDAO {
    
    //String-only the applicantTypes
    public List<String> getDeedCategory();
    
    public List<DeedCategoryModel> getModel();
   
    
}
