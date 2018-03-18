package unit;

import static unit.QualityType.INTEGER;
import static unit.QualityType.STRING;

public enum UnitQuality
{
	MAX_HEALTH(INTEGER), NAME(STRING);
	
	private final QualityType qualityType;
	
	public QualityType getQualityType() {
		return qualityType;
	}

	UnitQuality(QualityType qualityType)
	{
		this.qualityType = qualityType;
	}
}
