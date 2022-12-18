package dls.ioc.common.enums;

/**
 * Enum class for prompt text messages
 * 
 * @author <a href="diego.loira@gmail.com">Diego Loira</a>
 * 
 */
public enum MessagesEnum {

	KEY_MSG_LOADCONTEXT_STARTING("Context loading..."),	
	KEY_MSG_PRINTCONTEXT_STARTING("Context printing..."),
	KEY_MSG_PRINTCONTEXT_OBJECTACCESSING("accesing to object:"),
	KEY_MSG_PRINTCONTEXT_OBJECTCLASS("\t CLASS: "),
	KEY_MSG_PRINTCONTEXT_OBJECTVARIABLE("\t VARIABLE: ");

	private String _key;

	private MessagesEnum(String key) {
		this._key = key;
	}

	public String getValue() {
		return this._key;
	}
}
