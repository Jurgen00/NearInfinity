package infinity.resource.toh;

import infinity.datatype.*;
import infinity.resource.*;

@SuppressWarnings("serial")
public final class StrRefEntry extends AbstractStruct {

	public StrRefEntry() throws Exception 
	{
		super(null, "StrRef entry", new byte[28], 0); 
	}

	public StrRefEntry(AbstractStruct superStruct, byte buffer[], int offset, int nr) throws Exception
	{
		super(superStruct, "StrRef entry " + nr, buffer, offset);
	}

	public StrRefEntry(AbstractStruct superStruct, String name, byte[] buffer, int offset) throws Exception
	{
		super(superStruct, name, buffer, offset);
	}

	protected int read(byte[] buffer, int offset) throws Exception 
	{
		list.add(new StringRef(buffer, offset, "Overridden strref"));
		list.add(new Unknown(buffer, offset + 4, 4));
		list.add(new Unknown(buffer, offset + 8, 4));
		list.add(new Unknown(buffer, offset + 12, 4));
		list.add(new ResourceRef(buffer, offset + 16, "Associated sound", "WAV"));
		list.add(new HexNumber(buffer, offset + 24, 4, "TOT string offset"));
		return offset + 28; 	
	}

}
