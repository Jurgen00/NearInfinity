package infinity.resource.tot;

import infinity.datatype.Unknown;
import infinity.resource.*;
import infinity.resource.key.ResourceEntry;

@SuppressWarnings("serial")
public final class TotResource extends AbstractStruct implements Resource
{
	public TotResource(ResourceEntry entry) throws Exception
	{
		super(entry);
	}

	protected int read(byte[] buffer, int offset) throws Exception 
	{
		if (buffer != null && buffer.length > 0) {
			// TODO: fetch number of valid string entries from associated TOH resource
			for (int i = 1; offset + 524 <= buffer.length; i++) {
				StringEntry entry = new StringEntry(this, buffer, offset, i);
				offset = entry.getEndOffset();
				list.add(entry);
			}
		} else
			list.add(new Unknown(buffer, offset, 0, "(Empty)"));  // Placeholder for empty structure

		int endoffset = offset;
		for (int i = 0; i < list.size(); i++) {
			StructEntry entry = list.get(i);
			if (entry.getOffset() + entry.getSize() > endoffset)
				endoffset = entry.getOffset() + entry.getSize();
		}

		return endoffset;
	}

}
