package se.itello.example.payments.enums;

public enum PostType {

	O("OpeningPost"), B("BePaymentPOst"), start("00"), pay("30"), end("99");

	/**
	 * @uml.property  name="value"
	 */
	private String value;

	private PostType(String value) {
		this.value = value;
	}

	/**
	 * @return
	 * @uml.property  name="value"
	 */
	public String getValue() {
		return value;
	}

}
