package pl.pawelozdoba.britenet.web.konwerter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pl.pawelozdoba.britenet.domain.RodzajMuzyki;
import pl.pawelozdoba.britenet.domain.Wykonawca;
@FacesConverter("rodzajMuzykiKonwerter")
public class RodzajMuzykiKonwerter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value==null || value.isEmpty())
			return null;
		String[] tab=value.split(";");
		if(tab[0].isEmpty())
			return new RodzajMuzyki(tab[1]);
		else{
			
			Integer id= Integer.parseInt(tab[0]);
			return new RodzajMuzyki(id,tab[1]);
		}
			
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value== null)
			return "";
		RodzajMuzyki rodzajMuzyki = (RodzajMuzyki)value;
		if(rodzajMuzyki.getId()==null)
			return ";"+rodzajMuzyki.getNazwa();
		else
			return rodzajMuzyki.getId()+";"+rodzajMuzyki.getNazwa();
		
	}

	
	
	
	
}
