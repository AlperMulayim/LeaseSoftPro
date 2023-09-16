import { Injectable, NgZone } from '@angular/core';
import { Observable } from 'rxjs';
import { LsNotification } from '../modals/LsNotification';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor() {
  }

  public getNotifications(): Observable<LsNotification> {

    let eventSource = new EventSource(
      'http://localhost:8080/api/v1/notifications'
    );
    return new Observable(observer => {
      eventSource.addEventListener('Notification', (event) => {
        observer.next(event.data);
      })
    });

  }
}



