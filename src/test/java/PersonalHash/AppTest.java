package PersonalHash;

import org.junit.Test;

import static org.junit.Assert.*;
// import static org.junit.Assert.assertTrue;

public class AppTest {

  @Test
  public void constructor() {
    HashTable<String, String> table = setup();
    table.put("Elliot", "toillE");
    table.remove("toillE");
    //assertTrue(table.keySet().contains("Elliot"));
    table.put("Elliot","toillE");
    assertEquals(table.getCollisions(),0);

    assertEquals(table.keySet().size(),1);
    assertEquals(table.valueSet().size(),1);
    try{
      table.put("Elliot","Adamson");
      fail();
    }catch(DuplicateKeyException e){}
    table.remove("toillE");
    assertFalse(table.contains("toillE"));
    Pair<String,String> pair1=new Pair("Elliot","toillE");
    Pair<String,String> pair2=new Pair("Elliot","toillE");
    assertEquals(pair1,pair2);
    assertFalse(table.keySet().contains("Elliot"));
    assertFalse(table.valueSet().contains("toillE"));
    assertEquals(table.keySet().size(),0);
    assertEquals(table.valueSet().size(),0);
  }
  @Test
  public void testSet(){

    Set<String> set=new Set();
    set.put("Elliot");
    assertTrue(set.contains("Elliot"));
    assertFalse(set.contains("toillE"));
    try{
      set.remove(null);
      fail();
    }
    catch(IllegalArgumentException e){}
    set.remove("toillE");
    assertTrue(set.contains("Elliot"));
    set.remove("Elliot");
    assertFalse(set.contains("Elliot"));
    assertEquals(set.size(),0);
  }

  private HashTable<String, String> setup() {
    return new Hash_Impl<>(100000);
  }
}
