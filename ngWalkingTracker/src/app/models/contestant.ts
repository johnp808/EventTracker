export class Contestant {
  id: number;
  name: string;
  gender: string;
  age: number;
  contestantImage: string;
  representingCity: string;
  representingState: string;
  eventName: string;
  eventDate: string;
  finishTime: string;
  place: number;

  constructor(id: number = 0,
    name: string = '',
    gender: string = '',
    age: number = 0,
    contestantImage: string = '',
    representingCity: string = '',
    representingState: string = '',
    eventName: string = '',
    eventDate: string = '',
    finishTime: string = '',
    place: number = 0
     ) {

    this.id = id;
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.contestantImage = contestantImage;
    this.representingCity = representingCity;
    this.representingState = representingState;
    this.eventName = eventName;
    this.eventDate = eventDate;
    this.finishTime = finishTime;
    this.place = place;
  }
}
