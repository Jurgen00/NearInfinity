// Near Infinity - An Infinity Engine Browser and Editor
// Copyright (C) 2001 - 2005 Jon Olav Hauglid
// See LICENSE.txt for license information

package infinity.resource.sto;

import infinity.datatype.*;
import infinity.resource.AbstractStruct;
import infinity.resource.AddRemovable;

public final class Drink extends AbstractStruct implements AddRemovable
{
  Drink() throws Exception
  {
    super(null, "Drink", new byte[20], 0);
  }

  Drink(AbstractStruct superStruct, byte buffer[], int offset) throws Exception
  {
    super(superStruct, "Drink", buffer, offset);
  }

//--------------------- Begin Interface AddRemovable ---------------------

  public boolean canRemove()
  {
    return true;
  }

//--------------------- End Interface AddRemovable ---------------------

  protected int read(byte buffer[], int offset) throws Exception
  {
    list.add(new ResourceRef(buffer, offset, "Rumor", "DLG"));
    list.add(new StringRef(buffer, offset + 8, "Drink name"));
    list.add(new DecNumber(buffer, offset + 12, 4, "Price"));
    list.add(new DecNumber(buffer, offset + 16, 4, "Rumor rate"));
    return offset + 20;
  }
}

