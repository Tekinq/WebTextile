package converter;

/**
 *
 * @author yalci
 */
import dao.CityDAO;
import entity.City;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("cityConverter")
public class CityConverter implements Converter {

    private CityDAO cityDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        City c = this.getCityDao().findByID(id); //bize verilen id'yi nesne ile donusturduk
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        City c = (City) t;
        return String.valueOf(c.getId());
    }

    public CityDAO getCityDao() {
        //null ise yenisini olustur
        if (cityDao == null) {
            this.cityDao = new CityDAO();
        }
        return cityDao;
    }

    public void setCityDao(CityDAO cityDao) {
        this.cityDao = cityDao;
    }

}
