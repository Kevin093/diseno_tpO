package domain.connect.account;

import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import domain.stockObjects.accounts.Enterprise;
import exception.InvalidFormattAtInputException;

// Clase que se encarga de las conexiones
public class AccountsLoader {

	public AccountsLoader() {
		super();
	}

	public List<Enterprise> loadEnterprisesAccounts() {
		ExternalAccountRepo newExternalAccountRepo = new ExternalAccountRepo();
		String jsonStringFromExternalAccountRepo = newExternalAccountRepo.enterprisesFromService();
		return parseJsonToEnterpriseList(jsonStringFromExternalAccountRepo);

	}

	private List<Enterprise> parseJsonToEnterpriseList(String jsonFileWithEnterpriseListFormat) {
		Type listType = new TypeToken<List<Enterprise>>() {
		}.getType();
		return new Gson().fromJson(jsonFileWithEnterpriseListFormat, listType);

	}

}
