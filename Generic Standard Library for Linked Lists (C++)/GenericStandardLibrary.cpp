#include <iostream>
using namespace std;

//###################################################################
template <class T>
struct SinglyNode                      //Strut of SinglyLL and SinglyCL 
{
    T data;
    struct SinglyNode *next;
};
//###################################################################
template <class T>
struct DoubleyNode                    //Struct od DoublyLL and DoublyCL
{
    T data;
    struct DoubleyNode *next;
    struct DoubleyNode *prev;
};

//###################################################################
template <class T>
class DoublyCL                       //Doubly Circular Linklist
{
public:
    struct DoubleyNode<T> * head;
    struct DoubleyNode<T> * tail;
    int iCount;

    DoublyCL();

    void InsertFirst(T no);

    void InsertLast(T no);

    void DeleteFirst();

    void DeleteLast();

    void InsertAtPos(T no, int ipos);

    void DeleteAtPos(int ipos);

    void Display();

    int Count();
};
template <class T>
DoublyCL<T>::DoublyCL()
{
    head = NULL;
    tail = NULL;
    iCount = 0;
}
template <class T>
void DoublyCL<T>::InsertFirst(T no)
{
    struct DoubleyNode<T> * newn = NULL;

    newn = new DoubleyNode<T>;

    newn->data = no;
    newn->next = NULL;
    newn->prev = NULL;

    if ((head == NULL) && (tail == NULL))
    {
        head = newn;
        tail = newn;
    }
    else
    {
        newn->next = head;
        head->prev = newn;

        head = newn;
    }
    tail->next = head;
    head->prev = tail;
    iCount++;
}
template <class T>
void DoublyCL<T>::InsertLast(T no)
{
    struct DoubleyNode<T> * newn = NULL;

    newn = new DoubleyNode<T>;

    newn->data = no;
    newn->next = NULL;
    newn->prev = NULL;

    if ((head == NULL) && (tail == NULL))
    {
        head = newn;
        tail = newn;
    }
    else
    {
        tail->next = newn;
        newn->prev = tail;

        tail = newn;
    }
    tail->next = head;
    head->prev = tail;
    iCount++;
}
template <class T>
void DoublyCL<T>::DeleteFirst()
{
    if (head == NULL && tail == NULL)
    {
        return;
    }
    else if (head == tail)
    {
        delete (head);
        head = NULL;
        tail = NULL;
    }
    else
    {
        head = head->next;
        delete (tail->next);

        tail->next = head;
        head->prev = tail;
    }
    iCount--;
}
template <class T>
void DoublyCL<T>::DeleteLast()
{
    if (head == NULL && tail == NULL)
    {
        return;
    }
    else if (head == tail)
    {
        delete (head);
        head = NULL;
        tail = NULL;
    }
    else
    {
        tail = tail->prev;
        delete (tail->next);

        tail->next = head;
        head->prev = tail;
    }
    iCount--;
}
template <class T>
void DoublyCL<T>::InsertAtPos(T no, int ipos)
{

    int i = 0;

    struct DoubleyNode<T> * newn = NULL;
   struct DoubleyNode<T> * temp = NULL;

    if ((ipos < 1) || (ipos > iCount + 1))
    {
        printf("Invalid position\n");
        return;
    }

    if (ipos == 1)
    {
        InsertFirst(no);
    }
    else if (ipos == iCount + 1)
    {
        InsertLast(no);
    }
    else
    {
        newn = new DoubleyNode<T>;

        newn->data = no;
        newn->next = NULL;
        newn->prev = NULL;

        temp = head;

        for (i = 1; i < ipos - 1; i++)
        {
            temp = temp->next;
        }

        newn->next = temp->next;
        temp->next->prev = newn;

        temp->next = newn;
        newn->prev = temp;
        iCount++;
    }
}

template <class T>
class DoubleyLL
{
public:
   struct DoubleyNode<T> * head;
    int iCount;

    DoubleyLL();
    void InsertFirst(T  no);

    void InsertLast(T no);

    void InsertAtPos(T  no, int ipos);

    void DeleteFirst();

    void DeleteLast();

    void DeleteAtPos(int ipos);

    void Display();

    int Count();
};

//###################################################################
template <class T>
DoubleyLL<T>::DoubleyLL()                   //Doubly Linera LinkList
{
    head = NULL;
    iCount = 0;
}
template <class T>
void DoubleyLL<T>:: InsertFirst(T  no)
{
   struct DoubleyNode<T> *newn = NULL;

    newn = new DoubleyNode<T>;
    newn->data = no;
    newn->next = NULL;

    if (head == NULL)
    {
        head = newn;
    }
    else
    {
        newn->next = head;
        head->prev = newn;
        head = newn;
    }
    iCount++;
}
template <class T>
void DoubleyLL<T>::InsertLast(T  no)
{
   struct DoubleyNode<T> * newn = NULL;
  struct DoubleyNode<T> * temp= NULL;

    newn = new DoubleyNode<T>;
    newn->data = no;
    newn->next = NULL;
    newn->prev = NULL;

    if (head == NULL)
    {
        head = newn;
    }
    else
    {
        temp = head;

        while (temp->next != NULL)
        {
            temp = temp->next;
        }

        temp->next = newn;
        newn->prev = temp;
    }
    iCount++;
}
template <class T>
void DoubleyLL<T>::InsertAtPos(T no, int ipos)
{
    int CountNode = 0;
    int i = 0;
    struct DoubleyNode<T> * newn = NULL;
    struct DoubleyNode<T> * temp = NULL;

    CountNode = iCount;

    if ((ipos < 1) || (ipos > CountNode + 1))
    {
        printf("Invalid Position \n");
        return;
    }

    if (ipos == 1)
    {
        InsertFirst(no); 
    }
    else if (ipos == CountNode + 1)
    {
        InsertLast(no); 
    }
    else 
    {
        newn = new DoubleyNode<T>;
        newn->data = no;
        newn->next = NULL;
        newn->prev = NULL;

        temp = head;

        for (i = 1; i < ipos - 1; i++)
        {
            temp = temp->next;
        }
        newn->next = temp->next;
        newn->next->prev = newn;

        temp->next = newn;
        temp->prev = temp;
    }
    iCount++;
}
template <class T>
void DoubleyLL<T>::DeleteFirst()
{
    struct DoubleyNode<T> * temp = NULL;

    if (head == NULL)
    {
        return;
    }
    else if (head->next == NULL)
    {
        delete head;
        head = NULL;
    }
    else
    {
        temp = head;

        head = head->next;
        delete temp;
        head->prev = NULL;
    }
    iCount--;
}
template <class T>
void DoubleyLL<T>::DeleteLast()
{
    struct DoubleyNode<T> * temp = NULL;

    if (head == NULL)
    {
        return;
    }
    else if (head->next == NULL)
    {
        delete head;
        head = NULL;
    }
    else
    {
        temp = head;

        while (temp->next->next != NULL)
        {
            temp = temp->next;
        }

        delete temp->next;
        temp->next = NULL;
    }
    iCount--;
}
template <class T>
void DoubleyLL<T>:: DeleteAtPos(int ipos)
{
    int CountNode = 0;
    int i = 0;

    struct DoubleyNode<T> * temp = NULL;
   struct DoubleyNode<T> * target = NULL;

    CountNode = iCount;

    if ((ipos < 1) || (ipos > CountNode + 1)) // filter
    {
        printf("Invalid Position \n");
        return;
    }

    if (ipos == 1) 
    {
        DeleteFirst(); 
    }
    else if (ipos == CountNode + 1) 
    {
        DeleteLast(); 
    }
    else 
    {
        temp = head;

        for (i = 1; i < ipos - 1; i++)
        {
            temp = temp->next;
        }

        target = temp->next;

        temp->next = target->next;
        temp->next->prev = temp;
        delete (target);
    }
    iCount--;
}
template <class T>
void DoubleyLL<T>:: Display()
{
    struct DoubleyNode<T> * temp = head;

    cout << "Elements of LinkedList are : \n";

    while (temp != NULL)
    {
        cout << "| " << temp->data << " | -> ";
        temp = temp->next;
    }

    cout << "NULL\n";
}
template <class T>
int  DoubleyLL<T>::Count()
{
    return iCount;
}

template <class T>
void DoublyCL<T>::DeleteAtPos(int ipos)
{

    int i = 0;

    struct DoubleyNode<T> * temp = NULL;

    if ((ipos < 1) || (ipos > iCount))
    {
        printf("Invalid position\n");
        return;
    }

    if (ipos == 1)
    {
        DeleteFirst();
    }
    else if (ipos == iCount)
    {
        DeleteLast();
    }
    else
    {
        temp = head;

        for (i = 1; i < ipos - 1; i++)
        {
            temp = temp->next;
        }

        temp->next = temp->next->next;
        delete (temp->next->prev);
        temp->next->prev = temp;
        iCount--;
    }
}
template <class T>
void DoublyCL<T>::Display()
{
    struct DoubleyNode<T> * temp = head;

    cout << "Elements of LinkedList are : \n";

    do
    {
        cout << "| " << temp->data << " | <=> ";
        temp = temp->next;
    } while (temp != head);
    cout << "\n";
}
template <class T>
int DoublyCL<T>::Count()
{
    return iCount;
}

template <class T>
class SinglyCL
{
public:
    struct SinglyNode<T> * head;
    struct SinglyNode<T> * tail;
    int iCount;

    SinglyCL();

    void InsertFirst(T no);

    void InsertLast(T no);

    void DeleteFirst();

    void DeleteLast();

    void Display();

    int Count();

    void InsertAtPos(T no, int ipos);

    void DeleteAtPos(int ipos);
};

//###################################################################
template <class T>
SinglyCL<T>::SinglyCL()                   //Singly Circular Linklist
{
    head = NULL;
    tail = NULL;
    iCount = 0;
}
template <class T>
void SinglyCL<T>::InsertFirst(T no)
{
   struct SinglyNode<T> * newn = NULL;

    newn = new SinglyNode<T>;
    newn->data = no;
    newn->next = NULL;

    if ((head == NULL) && (tail == NULL)) // LL is empty
    {
        head = newn;
        tail = newn;
    }
    else
    {
        newn->next = head;
        head = newn;
    }
    tail->next = head;
    iCount++;
}
template <class T>
void SinglyCL<T>::InsertLast(T no)
{
    struct SinglyNode<T> * newn = NULL;

    newn = new SinglyNode<T>;
    newn->data = no;
    newn->next = NULL;

    if ((head == NULL) && (tail == NULL)) // LL is empty
    {
        head = newn;
        tail = newn;
    }
    else
    {
        tail->next = newn;
        tail = newn;
    }
    tail->next = head;
    iCount++;
}
template <class T>
void SinglyCL<T>::DeleteFirst()
{
    struct SinglyNode<T> * temp = NULL;
    if ((head == NULL) && (tail == NULL))
    {
        return;
    }
    else if (head == tail)
    {
        delete head;
        head = NULL;
        tail = NULL;
    }
    else
    {
        temp = head;

        head = head->next;
        delete (temp);
        tail->next = head;
    }
    iCount--;
}
template <class T>
void SinglyCL<T>::DeleteLast()
{
   struct SinglyNode<T> * temp = NULL;
    if ((head == NULL) && (tail == NULL))
    {
        return;
    }
    else if (head == tail)
    {
        delete head;
        head = NULL;
        tail = NULL;
    }
    else
    {
        temp = head;

        while (temp->next != tail)
        {
            temp = temp->next;
        }

        delete (temp->next);
        tail = temp;
        tail->next = head;
    }
    iCount--;
}
template <class T>
void SinglyCL<T>::Display()
{
    struct SinglyNode<T> * temp = head;

    cout << "Elements of LinkedList are : \n";

    do
    {
        cout << "| " << temp->data << " | <=> ";
        temp = temp->next;
    } while (temp != head);
    cout << "\n";
}
template <class T>
int SinglyCL<T>::Count()
{
    return iCount;
}
template <class T>
void SinglyCL<T>::InsertAtPos(T no, int ipos)
{

    int i = 0;

    struct SinglyNode<T> * newn = NULL;
    struct SinglyNode<T> * temp = NULL;

    if (ipos < 1 || ipos > iCount + 1)
    {
        printf("Invalid position \n");
        return;
    }

    if (ipos == 1)
    {
        InsertFirst(no);
    }
    else if (ipos == iCount)
    {
        InsertLast(no);
    }
    else
    {
        newn = new SinglyNode<T>;
        newn->data = no;
        newn->next = NULL;

        temp = head;

        for (i = 1; i < ipos - 1; i++)
        {
            temp = temp->next;
        }

        newn->next = temp->next;

        temp->next = newn;
        iCount++;
    }
}
template <class T>
void SinglyCL<T>::DeleteAtPos(int ipos)
{
    int iCount = 0;
    int i = 0;

   struct SinglyNode<T> * temp = NULL;
    struct SinglyNode<T> * target = NULL;

    iCount = Count();

    if (ipos < 1 || ipos > iCount + 1)
    {
        printf("Invalid position \n");
        return;
    }

    if (ipos == 1)
    {
        DeleteFirst();
    }
    else if (ipos == iCount + 1)
    {
        DeleteLast();
    }
    else
    {

        temp = head;

        for (i = 1; i < ipos - 1; i++)
        {
            temp = temp->next;
        }

        target = temp->next;

        temp->next = target->next;
        iCount--;
        delete (target);
    }
}

//###################################################################
template <class T>
class SinglyLL                      //Singly Linear linkList
{    
    public:
        struct SinglyNode<T> * head;
        int iCount;

        SinglyLL();
        void InsertFirst(T no);
        void InsertLast(T no);
        void InsertAtPos(T no , int ipos);
        void DeleteFirst();
        void DeleteLast();
        void DeleteAtPos(int ipos);
        void Display();
        int Count();
};

//###################################################################
template <class T>
SinglyLL<T>::SinglyLL()
{
    head = NULL;
    iCount = 0;
}

template <class T>
void SinglyLL<T>::InsertFirst(T no)
{
    struct SinglyNode<T> * newn = NULL;

    newn = new SinglyNode<T>;    
    newn->data = no;
    newn->next = NULL;

    if(head == NULL)
    {
        head = newn;
    }
    else
    {
        newn->next = head;
        head = newn;
    }
    iCount++;
}

template <class T>
void SinglyLL<T>::InsertLast(T no)
{
    struct SinglyNode<T> * newn = NULL;
    struct SinglyNode<T> * temp = NULL;

    newn = new SinglyNode<T>;   
    newn->data = no;
    newn->next = NULL;

    if(head == NULL)
    {
        head = newn;
    }
    else
    {
        temp = head;

        while(temp -> next != NULL)
        {
            temp = temp -> next;
        }

        temp->next = newn;
    }
    iCount++;
}

template <class T>
void SinglyLL<T>::InsertAtPos(T no , int ipos)
{
    int i = 0;
    struct SinglyNode<T> * newn = NULL;
    struct SinglyNode<T> * temp = NULL;

    if((ipos < 1) || (ipos > iCount+1))
    {
        cout<<"Invalid position\n";
        return;
    }

    if(ipos == 1)
    {
        InsertFirst(no);
    }
    else if(ipos == iCount + 1)
    {
        InsertLast(no);
    }
    else
    {
        newn = new SinglyNode<T>;
        newn->data = no;
        newn->next = NULL;

        temp = head;

        for(i =1; i< ipos -1; i++)
        {
            temp = temp->next;
        }

        newn->next = temp->next;
        temp->next = newn;

        iCount++;
    }
}

template <class T>
void SinglyLL<T>::DeleteFirst()
{
    struct SinglyNode<T> * temp = NULL;

    if(head == NULL)
    {
        return;
    }
    else if(head->next == NULL)
    {
        delete head;
        head = NULL;
    }
    else
    {
        temp = head;

        head = head -> next;
        delete temp;
    }
    iCount--;
}

template <class T>
void SinglyLL<T>::DeleteLast()
{
    struct SinglyNode<T> * temp = NULL;

    if(head == NULL)
    {
        return;
    }
    else if(head->next == NULL)
    {
        delete head;
        head = NULL;
    }
    else
    {
        temp = head;

        while(temp->next->next != NULL)
        {
            temp = temp -> next;
        }

        delete temp->next;
        temp->next = NULL;
    }
    iCount--;
}

template <class T>
void SinglyLL<T>::DeleteAtPos(int ipos)
{
    int i = 0;
    struct SinglyNode<T> * temp = NULL;
    struct SinglyNode<T> * target = NULL;

    if((ipos < 1) || (ipos > iCount))
    {
        cout<<"Invalid position\n";
        return;
    }

    if(ipos == 1)
    {
        DeleteFirst();
    }
    else if(ipos == iCount)
    {
        DeleteLast();
    }
    else
    {
        temp = head;

        for(i =1; i< ipos -1; i++)
        {
            temp = temp->next;
        }

        target = temp->next;

        temp -> next = target->next;
        delete target;

        iCount--;
    }
}

template <class T>
void SinglyLL<T>::Display()
{
    struct SinglyNode<T> * temp = head;

    cout<<"Elements of LinkedList are : \n";

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" | -> ";
        temp = temp -> next;
    }

    cout<<"NULL\n";
}

template <class T>
int SinglyLL<T>::Count()
{
    return iCount;
}

//###################################################################
int main()
{
    SinglyLL <int>singlyLL;
    SinglyCL <int>singlyCL;
    DoublyCL <int>doublyCL;
    DoubleyLL <int>doubleyLL;
   
    int iRet = 0, iValue = 0, iPos = 0;
    int choice = 0,listType = 0;

     while (true)
        {
            cout << "###################################################################\n";
            cout << "\nSelect Linked List Type:\n";
            cout << "1. Singly Linked List\n";
            cout << "2. Doubly Linked List\n";
            cout << "3. Singly Circular Linked List\n";
            cout << "4. Doubly Circular Linked List\n";
            cout << "5. Exit\n";
            cout << "Enter your choice: ";
            cin >> listType;
            cout << "###################################################################\n";
            if (listType == 5)
            {
                cout << "######################Exiting the program.#########################\n";
                break;
            }

            cout << "###################################################################\n";
            cout << "\nSelect Operation:\n";
            cout << "1 : Insert new element at first position\n";
            cout << "2 : Insert new element at last position\n";
            cout << "3 : Insert new element at given position\n";
            cout << "4 : Delete the element from first position\n";
            cout << "5 : Delete the element from last position\n";
            cout << "6 : Delete the element from given position\n";
            cout << "7  :Display the elements\n";
            cout << "8. Count the Elements\n";
            cout << "Enter your choice: ";
            cin >> choice;
            cout << "###################################################################\n";

            switch (choice)
            {
            case 1: // Insert First
                cout << "Enter the value to insert: ";
                cin >> iValue;
                if (listType == 1)
                    singlyLL.InsertFirst(iValue);
                else if (listType == 2)
                    doubleyLL.InsertFirst(iValue);
                else if (listType == 3)
                    singlyCL.InsertFirst(iValue);
                else if (listType == 4)
                    doublyCL.InsertFirst(iValue);
                break;

            case 2: // Insert Last
                cout << "Enter the value to insert: ";
                cin >> iValue;
                if (listType == 1)
                    singlyLL.InsertLast(iValue);
                else if (listType == 2)
                    doubleyLL.InsertLast(iValue);
                else if (listType == 3)
                    singlyCL.InsertLast(iValue);
                else if (listType == 4)
                    doublyCL.InsertLast(iValue);
                break;

            case 3: // Insert at Position
                cout << "Enter the value to insert: ";
                cin >> iValue;
                cout << "Enter the position: ";
                cin >> iPos;
                if (listType == 1)
                    singlyLL.InsertAtPos(iValue, iPos);
                else if (listType == 2)
                    doubleyLL.InsertAtPos(iValue, iPos);
                else if (listType == 3)
                    singlyCL.InsertAtPos(iValue, iPos);
                else if (listType == 4)
                    doublyCL.InsertAtPos(iValue, iPos);
                break;

            case 4: // Delete First
                if (listType == 1)
                    singlyLL.DeleteFirst();
                else if (listType == 2)
                    doubleyLL.DeleteFirst();
                else if (listType == 3)
                    singlyCL.DeleteFirst();
                else if (listType == 4)
                    doublyCL.DeleteFirst();
                break;

            case 5: // Delete Last
                if (listType == 1)
                    singlyLL.DeleteLast();
                else if (listType == 2)
                    doubleyLL.DeleteLast();
                else if (listType == 3)
                    singlyCL.DeleteLast();
                else if (listType == 4)
                    doublyCL.DeleteLast();
                break;

            case 6: // Delete at Position
                cout << "Enter the position: ";
                cin >> iPos;
                if (listType == 1)
                    singlyLL.DeleteAtPos(iPos);
                else if (listType == 2)
                    doubleyLL.DeleteAtPos(iPos);
                else if (listType == 3)
                    singlyCL.DeleteAtPos(iPos);
                else if (listType == 4)
                    doublyCL.DeleteAtPos(iPos);
                break;

            case 7: // Display List
                if (listType == 1)
                    singlyLL.Display();
                else if (listType == 2)
                    doubleyLL.Display();
                else if (listType == 3)
                    singlyCL.Display();
                else if (listType == 4)
                    doublyCL.Display();
                break;

            case 8: // Count Elements
                if (listType == 1)
                    cout << "Number of elements: " << singlyLL.Count() << endl;
                else if (listType == 2)
                    cout << "Number of elements: " << doubleyLL.Count() << endl;
                else if (listType == 3)
                    cout << "Number of elements: " << singlyCL.Count() << endl;
                else if (listType == 4)
                    cout << "Number of elements: " << doublyCL.Count() << endl;
                break;

             default://break
                     cout<<"Thank you for using the application\n";
                     break;
        } /// end of Switch case
       
        }  //end of while operation

   
    return 0;
  
}