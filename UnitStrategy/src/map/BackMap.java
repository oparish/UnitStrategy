package map;

import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class BackMap
{
	private static final String ROWS = "ROWS";
	private static final String TERRAIN = "TERRAIN";
	
	private ArrayList<ArrayList<MapCell>> mapCells = new ArrayList<ArrayList<MapCell>>();
	
	public BackMap(JsonObject jsonObject)
	{
		JsonArray rows = jsonObject.getJsonArray(ROWS);
		for (int i = 0; i < rows.size(); i++)
		{
			ArrayList<MapCell> newRow = new ArrayList<MapCell>();
			JsonArray row = rows.getJsonArray(i);
			for (int j = 0; j < row.size(); j++)
			{
				JsonObject mapCellObject = row.getJsonObject(j);
				TerrainType terrainType = TerrainType.valueOf(mapCellObject.getString(TERRAIN));
				MapCell mapCell = new MapCell(terrainType);
				newRow.add(mapCell);
			}
			this.mapCells.add(newRow);
		}
	}
}
