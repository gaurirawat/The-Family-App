export class GlobalConstants {
  public static baseUrl : String = "http://localhost:8010";

  public static loginUrl = GlobalConstants.baseUrl+"/login";
  public static getPerson = GlobalConstants.baseUrl +  '/person/get';
  public static setPerson = GlobalConstants.baseUrl +  '/person/set';
  public static getMemberFromFamilyIdUrl = GlobalConstants.baseUrl+"/family/get";

}
