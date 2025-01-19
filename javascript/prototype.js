function Person(firstname,lastname,age){
    this.firstname=firstname;
    this.lastname=lastname;
    this.age=age;
}
Person.prototype.school="vkv";
Person.prototype.print=function(){
      return this.firstname+this.lastname+" "+this.age;
};
function Player(firstname,lastname,age,game){
     Person.call(this,firstname,lastname,age);
     this.game=game;
}
Player.prototype=Object.create(Person.prototype);
Player.prototype.constructor=Player;
Player.prototype.printing=function(){
    return this.firstname+this.lastname+" "+this.age+this.game;
};

const person1=new Person("John","Doe",22);
const person2=new Person("kavi","Priya",33);
const player1=new Player("nithu","sri",23,"football");
const player2=new Player("karthi","ram",34,'cricket');

console.log(person1);
console.log(person2);
console.log(person1.print());
console.log(person2.print());

console.log(player1);
console.log(player2);
console.log(player1.printing());
console.log(player2.printing());
console.log(player1.print());
console.log(player2.print());