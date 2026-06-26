package com.keva.emp.Enum;


public enum Status {

	ACTIVE(1, "#0E8743"),
	DELETED(2, "#F31260"),
	DRAFT(3, "#668091"),
	SUCCESS(4, "#0E8743"),
	FAILED(5, "#F31260"),
	INACTIVE(6, "#668091"),
	ACCEPTED(7, "#0072C6"),
	REJECTED(8, "#C60F0F"),
	CANCELLED(9, "#FFA500");

	private final Integer id;
	private final String colorCode;

	Status(Integer id, String colorCode) {
		this.id = id;
		this.colorCode = colorCode;
	}

	public Integer getId() {
		return id;
	}

	public static Status getById(int id) {
		for (Status status : values())
			if (id == status.getId())
				return status;
		return null;

	}

	public String getColorCode() {
		return colorCode;
	}

	public static String getColorCodeById(int id) {
		Status status = getById(id);
		return (status != null) ? status.getColorCode() : null;
	}

}
