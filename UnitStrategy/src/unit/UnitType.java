package unit;

import static unit.UnitQuality.MAX_HEALTH;
import static unit.UnitQuality.NAME;

import java.util.HashMap;

import javax.json.JsonObject;

public class UnitType
{
	private HashMap<UnitQuality, String> stringQualityMap = new HashMap<UnitQuality, String>();
	private HashMap<UnitQuality, Integer> integerQualityMap = new HashMap<UnitQuality, Integer>();
	
	public UnitType(JsonObject jsonObject)
	{
		for (UnitQuality unitQuality : UnitQuality.values())
		{
			if (unitQuality.getQualityType() == QualityType.INTEGER)
			{
				integerQualityMap.put(unitQuality, jsonObject.getInt(unitQuality.name()));
			}
			else
			{
				stringQualityMap.put(unitQuality, jsonObject.getString(unitQuality.name()));
			}
		}
	}
	
	public int getMaxHealth()
	{
		return this.integerQualityMap.get(UnitQuality.MAX_HEALTH);
	}
	
	public String getName()
	{
		return this.stringQualityMap.get(NAME);
	}
}
