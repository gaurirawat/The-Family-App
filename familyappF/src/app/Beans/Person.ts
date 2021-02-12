export class Person {
  constructor(
    public username: String,
    public name: string,
    public password: string,
    public email: string,
    public contactNo: number,
    public sex:String,
    public dob: Date,
    public maritalStatus: String,
    public IsAvailableForMarriage : boolean,
    private isAlive : boolean,
  ){
  }
}
