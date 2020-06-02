import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User.model';
import { ConnectionService } from 'src/app/connection/connection.service';
import { Group } from 'src/app/models/Group.model';
import { FriendsService } from '../../friends/friends.service';
import { GroupsService } from '../groups.service';
import { Router } from '@angular/router';
import { Serializer } from 'src/app/models/serializer/Serializer';
import { Friend } from 'src/app/models/Friend.model';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {

  // TODO: string for name of group
  friends: Friend[];
  checkedFriends: Friend[];
  group: Group;

  constructor(
    private gs: GroupsService
    , private us: FriendsService
    , private cs: ConnectionService
    , private router: Router
    ) { }

  /**
   * Find all friends of connected user.
   * Push connected user at the first place of checkedFried's array.
   * Serialize them to typeScript object.
   */
  ngOnInit(): void {
    this.group = new Group(-1, this.cs.connectedUser.nickname + " Group")
    this.checkedFriends = [this.cs.connectedUser.toFriend()];
    this.us.findFriends(this.cs.connectedUser).subscribe( x => {
      x.forEach(y => Serializer.toTypeScriptObject<Friend>(y, Friend));
      this.friends = x;
      console.log(this.friends);
      
    });
  }

  /**
   * Control checked user and push/remove them to an array.
   * Keep connected User at the first array's index for stay admin of group.
   * @param u 
   */
  onCheckboxClicked(f: Friend): void {
    if (this.checkedFriends.includes(f)) {
      let pos = this.checkedFriends.findIndex(x => x == f);
      this.checkedFriends.splice(pos, 1);
    } else
    this.checkedFriends.push(f);
  }

  /**
   * Send to db and redirect to main.
   */
  onFormSubmit(): void {
    this.group.friends = this.checkedFriends;
    console.log(this.group);
    
    this.gs.createGroup(this.group).subscribe(x=>{
      this.router.navigateByUrl("main"); 
    });
  }
}
