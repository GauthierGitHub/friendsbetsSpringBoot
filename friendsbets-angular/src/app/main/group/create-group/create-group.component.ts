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
   * Serialize them to typeScript object.
   */
  ngOnInit(): void {
    this.group = new Group(-1, this.cs.connectedUser.nickname + " Group")
    this.checkedFriends = [this.cs.connectedUser];
    this.us.findFriends(this.cs.connectedUser).subscribe(x => {
      x.forEach(y => Serializer.toTypeScriptObject(y, Friend));
      this.friends = x;
    });
  }

  /**
   * Control checked friends and push/remove them to an array.
   * Keep connected User at the first array's index for stay admin of this group.
   * @param u : connected user.
   */
  onCheckboxClicked(u: User): void {
    if (this.checkedFriends.includes(u)) {
      let pos = this.checkedFriends.findIndex(x => x == u);
      this.checkedFriends.splice(pos, 1);
    } else
      this.checkedFriends.push(u);
  }

  /**
   * Send to db and redirect to main.
   */
  onFormSubmit(): void {
    this.group.friends = this.checkedFriends;
    this.gs.createGroup(this.group).subscribe(
      x => this.router.navigateByUrl("main")
    );
  }
}
