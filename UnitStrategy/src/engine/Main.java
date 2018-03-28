package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import map.BackMap;
import unit.UnitType;

public class Main
{
	private static final String UNITDATA_LOCATION = "src/data/UnitData.json";
	private static final String MAPDATA_LOCATION = "src/data/MapData.json";
	
	private static final String UNITTYPES = "UNITTYPES";
	
	public static void main(String[] args)
	{
		ArrayList<UnitType> unitTypeList = Main.loadUnitTypeList();
		BackMap backMap = Main.loadBackMap();
	}
	
	private static ArrayList<UnitType> loadUnitTypeList()
	{
		JsonObject unitData = Main.loadJsonObjectFromFilePath(UNITDATA_LOCATION);
		JsonArray unitTypes = unitData.getJsonArray(UNITTYPES);
		ArrayList<UnitType> unitTypeList = new ArrayList<UnitType>();
		
		for (int i = 0; i < unitTypes.size(); i++)
		{
			JsonObject unitTypeJson = unitTypes.getJsonObject(i);
			unitTypeList.add(new UnitType(unitTypeJson));
		}
		return unitTypeList;
	}
	
	private static BackMap loadBackMap()
	{
		JsonObject mapData = Main.loadJsonObjectFromFilePath(MAPDATA_LOCATION);
		BackMap backMap = new BackMap(mapData);
		return backMap;
	}
	
	protected static JsonObject loadJsonObjectFromFilePath(String filepath)
	{
		JsonObject jsonObject = null;
		FileReader fileReader;
		try
		{
			fileReader = new FileReader(new File(filepath));
			JsonReader jsonReader= Json.createReader(fileReader);	
			jsonObject = jsonReader.readObject();
			jsonReader.close();	
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return jsonObject;		
	}
}
