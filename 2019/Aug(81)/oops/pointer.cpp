#include <iostream>
using namespace std;

void test5()
{

    // int arr[4] = {1, 2, 3, 4};
    int *arr = new int(4);
    int size = sizeof(arr) / sizeof(int);
    cout << size;
}

void test4()
{
    long i = 97;
    long j = (long)(&i);
    cout << &i << " " << *(int *)j << endl;

    // long a = (1l << 62);
    // int b = (int)a;
    // cout << a << " " << b << endl;
}

int a = 10;
void test3(char)
{
    static int ii = 10;
    cout << ii << " " << a << endl;
    a++;
    ii++;
}
int *test2()
{
    static int a = 10;
    cout << a << " " << &a << endl;
    return &a;
}

void checkStack(int n)
{
    if (n == 2)
        return;
    int a = 10;
    cout << &a << endl;

    checkStack(n + 1);
}

void test1()
{
    int a = 10;
    int *p = &a;
    int **q = &p;

    cout << a << " " << &a << endl;
    cout << p << " " << &p << endl;
    cout << q << " " << &q << endl;
    cout << endl;
    cout << *q << " " << p << endl;
    cout << **q << " " << a << endl;
}

int main(int args, char **argv)
{
    // test1();
    // checkStack(0);
    // cout << test2();

    // for (int i = 0; i < 10; i++)
    // {
    //     test3();
    //     a++;
    // }

    // test4();
    test5();
    return 0;
}