package pl.pawelozdoba.britenet.web.konwerter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pl.pawelozdoba.britenet.domain.Wykonawca;

@FacesConverter("wykonawcaKonwerter")
public class WykonawcaKonwerter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value == null || value.isEmpty())
			return null;
		
		String[] tab = value.split(";");
		if(tab[0].isEmpty()){
			return new Wykonawca(tab[1]);
		}
		else {
			Integer id = Integer.parseInt(tab[0]);
			return new Wykonawca(id,tab[1]);
		}
		
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value == null)
			return "";
		
		Wykonawca wykonawca = (Wykonawca)value;
		if(wykonawca.getId() == null)
			return ";"+wykonawca.getNazwa();
		else
			return wykonawca.getId()+ ";"+wykonawca.getNazwa();
		//id nazwa
		//id;nazwa
		//null;nazwa ==> ;nazwa
		
	}

}
