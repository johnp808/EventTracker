import { Component, OnInit } from '@angular/core';
import { Contestant } from 'src/app/models/contestant';
import { ContestantService } from 'src/app/services/contestant.service';

@Component({
  selector: 'app-contestant-list',
  templateUrl: './contestant-list.component.html',
  styleUrls: ['./contestant-list.component.css']
})
export class ContestantListComponent implements OnInit {

contestants: Contestant[] = [];
  constructor(
    private contestantService: ContestantService
    ) { }

  ngOnInit(): void {
    this.loadContestants();
  }

  loadContestants(){
    this.contestantService.index().subscribe(
      contestants =>{
        this.contestants = contestants;
      },
      fail => {
        console.error('ContestantListComponent.loadContestants(): error loading contestants');
        console.error(fail);


      }
    )
  }
}
