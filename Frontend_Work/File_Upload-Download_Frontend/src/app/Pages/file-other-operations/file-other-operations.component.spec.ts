import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FileOtherOperationsComponent } from './file-other-operations.component';

describe('FileOtherOperationsComponent', () => {
  let component: FileOtherOperationsComponent;
  let fixture: ComponentFixture<FileOtherOperationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FileOtherOperationsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FileOtherOperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
