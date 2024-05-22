package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("tcKimlikNoValidator")
public class TCKimlikNoValidator implements Validator<String> {

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
		if (value.length() != 11) {
			throw new ValidatorException(new FacesMessage("TC Kimlik No 11 haneli olmalıdır."));
		}
		if (!value.matches("[0-9]+")) {
			throw new ValidatorException(new FacesMessage("TC Kimlik No sadece rakamlardan oluşmalıdır."));
		}
		if (value.startsWith("0")) {
			throw new ValidatorException(new FacesMessage("TC Kimlik No 0 ile başlayamaz."));
		}
		int tekSayiToplami = 0, ciftSayiToplami = 0;
		for (int i = 1; i <= 9; i += 2) {
			tekSayiToplami += Integer.parseInt(value.substring(i - 1, i));
		}
		for (int i = 2; i <= 8; i += 2) {
			ciftSayiToplami += Integer.parseInt(value.substring(i - 1, i));
		}
		int sondanIkinciBasamak = (tekSayiToplami * 7 - ciftSayiToplami) % 10;
		if (sondanIkinciBasamak != Integer.parseInt(value.substring(9, 10))) {
			throw new ValidatorException(new FacesMessage("Geçersiz TC Kimlik No. 1"));
		}
		int sonBasamak = (tekSayiToplami + ciftSayiToplami + sondanIkinciBasamak) % 10;
		if (sonBasamak != Integer.parseInt(value.substring(10, 11))) {
			throw new ValidatorException(new FacesMessage("Geçersiz TC Kimlik No. 2"));
		}
	}

	public static void main(String[] args) {
		String tcNo = "";
		new TCKimlikNoValidator().validate(null, null, tcNo);
		System.out.println("TC Kimlik No doğrudur");
	}

}
