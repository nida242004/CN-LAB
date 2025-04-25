

def search(data):
    x = input("Enter search element: ")
    for i in range(len(data)):
        if data[i] == x:
            print(f"Element found at {i}")
            return
    print("Element not Found!!")

def sort(data):
    for i in range(len(data)-1):
        flag = False
        for j in range(len(data)-i-1):
            if data[j] > data[j+1]:
                temp = data[j]
                data[j] = data[j+1]
                data[j+1] = temp
                flag = True
        if not flag:
            return

def update(data, key):
    if key not in data:
        print("Key not found")
    else:
        x = input("Enter a new value: ")
        data[key] = x

list_ = []

def list_op():
    print("List operations:")
    print("1.Insert\n2.Delete\n3.Update\n4.Search\n5.Sort\n6.Display\n7.Return to main")
    while True:
        ch = int(input("Enter choice: "))
        if ch == 1:
            x = input("Enter element: ")
            list_.append(x)
        elif ch == 2:
            ele = input("Enter element to be deleted: ")
            try:
                list_.remove(ele)
            except:
                print(f"Element {ele} not found")
        elif ch == 3:
            index = int(input("Enter index to update: "))
            if index < len(list_):
                new_val = input("Enter new value: ")
                list_[index] = new_val
            else:
                print("Invalid index")
        elif ch == 4:
            search(list_)
        elif ch == 5:
            sort(list_)
        elif ch == 6:
            print(list_)
        elif ch == 7:
            break
        else:
            print("Invalid choice")

def tuple_op():
    print("Enter tuple: ")
    tup = tuple(input().split())
    print("1.Display\n2.Search\n3.Exit")
    while True:
        ch = int(input("Enter the choice: "))
        if ch == 1:
            print(tup)
        elif ch == 2:
            search(tup)
        elif ch == 3:
            break
        else:
            print("Invalid choice")

myset = set()

def set_op():
    print("1.Add\n2.Remove\n3.Search\n4.Display\n5.Exit")
    while True:
        ch = int(input("Enter choice: "))
        if ch == 1:
            myset.add(input("Enter element: "))
        elif ch == 2:
            try:
                myset.remove(input("Enter element: "))
            except:
                print("Element not found")
        elif ch == 3:
            search(myset)
        elif ch == 4:
            print(myset)
        elif ch == 5:
            return
        else:
            print("Invalid choice")

dict_ = {}

def dict_operation():
    print("1.Insert\n2.Update\n3.Delete\n4.Search\n5.Display\n6.Exit")
    while True:
        ch = int(input("Enter your choice: "))
        if ch == 1:
            key = input("Enter key: ")
            value = input("Enter value: ")
            dict_[key] = value
        elif ch == 2:
            key = input("Enter the key: ")
            update(dict_, key)
        elif ch == 3:
            key = input("Enter key to be deleted: ")
            if key in dict_:
                del dict_[key]
            else:
                print("Key not found")
        elif ch == 4:
            ele = input("Enter value: ")
            for key, value in dict_.items():
                if value == ele:
                    print(key)
        elif ch == 5:
            print(dict_)
        elif ch == 6:
            break
        else:
            print("Invalid choice")

while True:
    print("1.List\n2.Tuples\n3.Set\n4.Dictionary\n5.Exit")
    ch = int(input("Enter choice: "))
    if ch == 1:
        list_op()
    elif ch == 2:
        tuple_op()
    elif ch == 3:
        set_op()
    elif ch == 4:
        dict_operation()
    elif ch == 5:
        break
    else:
        print("Invalid choice")
