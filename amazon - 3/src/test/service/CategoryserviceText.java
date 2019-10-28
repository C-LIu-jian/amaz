import com.huwa.entity.Category;
import com.huwa.service.CategoryService;
import com.huwa.serviceImpl.CategoryServiceImpl;
import org.junit.Test;

import java.util.List;

public class CategoryserviceText {
    private CategoryService categoryService =new CategoryServiceImpl();

    @Test
    public void  text(){
        try {
        List<Category> list= categoryService.rentalStart();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
