package converter;

/**
 *
 * @author yalci
 */
import dao.ClothesDAO;
import entity.Clothes;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("clothesConverter")
public class ClothesConverter implements Converter {

    private ClothesDAO clothesDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Clothes c = this.getClothesDao().findByID(id); //bize verilen id'yi nesne ile donusturduk
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Clothes c = (Clothes) t;
        return String.valueOf(c.getId());
    }

    public ClothesDAO getClothesDao() {
        if(clothesDao == null){
            this.clothesDao = new ClothesDAO(); 
        }
        return clothesDao;
    }

    public void setClothesDao(ClothesDAO clothesDao) {
        this.clothesDao = clothesDao;
    }

}
