import { Injectable } from '@angular/core';
import { ConnectionService } from 'src/app/connection/connection.service';
import { User } from 'src/app/models/User.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Group } from 'src/app/models/Group.model';
import { Serializer } from '../../models/serializer/Serializer'
import { Friend } from 'src/app/models/Friend.model';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  private url: string = "http://localhost:8080/";

  constructor(private httpClient: HttpClient) { }

  /**
   * Create a new Group.
   * Connected User will be the first of the set, so the admin.
   * @param g 
   */
  public createGroup(g: Group): Observable<Group> {
    // convert friends to users
    let ids: number[] = new Array();
    g.friends.forEach(friend => {
      ids.push(friend.id);
    });
    g.users = ids;
    // delete uneeded data
    g.id = undefined;
    g.friends = undefined;
    // serialize
    g = Serializer.serializeToJSON(g);    
    return this.httpClient.post<Group>(this.url + "group", Serializer.serializeToJSON(g));
  }

  /**
   * Find all group where the user is in the fiendList.
   * @param u 
   */
  public findAllForOneUser(u: User): Observable<Group[]> {
    return this.httpClient.get<Group[]>(this.url + "group/mygroups/" + u.id);
  }

  /**
   * Find a group with an id;
   * @param id 
   */
  public findById(id: string): Observable<Group> {
    return this.httpClient.get<Group>(this.url + "group/" + id);
  }

}
