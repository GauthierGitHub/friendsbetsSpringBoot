import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/User.model';
import { Friend } from 'src/app/models/Friend.model';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  private url: string = "http://localhost:8080/friend/";

  constructor(private httpClient: HttpClient) { }

  /**
   * Find all other users who are not already friends or himself.
   * Will be user phone repertory.
   * @param u : User who is searching friends.
   */
  public findAllOthers(u: User): Observable<Friend[]> {
    return this.httpClient.get<Friend[]>(this.url + "find/" + u.id);
  }

  /**
   * Add selected users to connected user friends.
   * Friendship is bidirectionnal.
   * @param friends 
   * @param u 
   */
  public addFriends(friends: Friend[], u: User): Observable<User[]> {
    return this.httpClient.post<User[]>(this.url + "add/" + u.id, friends);
  }

  /**
   * Find all friends for one user.
   * @param u 
   */
  public findFriends(u: User): Observable<Friend[]> {
    // TODO: Get all friends for one user
    return this.httpClient.get<Friend[]>(this.url + "findfriends/" + u.id);
  }
}
