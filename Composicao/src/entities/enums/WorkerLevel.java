package entities.enums;

public enum WorkerLevel {

	JUNIOR("Júnior"), PLENO("Pleno"), SENIOR("Sênior");
	
	private String level;
	
	private WorkerLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return this.level;
	}
}
