// Task 1: Code a Person class
class Person{
    constructor(name = "Tom", age = 20, energy = 100) {
        this.name = name;
        this.age = age;
        this.energy = energy;
    }

    sleep() {
        this.energy += 10;
    }

    doSomethingFun() {
        this.energy -= 10;
    }
}

// Task 2: Code a Worker class
class Worker extends Person{
    /*The Worker class has all the paramerters and methods of its super-class. */
    constructor(name = "Tom", age = 20, energy = 100, xp = 0, hourlyWage = 10) {
        super(name, age, energy)
        this.xp = xp;
        this.hourlyWage = hourlyWage;
    }

    doSomethingFun(){
        super.doSomethingFun;
    }

    sleep() {
        super.sleep;
    }

    goToWork() {
        this.xp += 10;
    }
}

// Task 3: Code an intern object, run methods
function intern() {
    let intern = new Worker("Bob", 21, 110, 0, 10);
    intern.goToWork(); //Run the goToWork() method on the intern object. 
    return intern; //return the intern object.
}

// Task 4: Code a manager object, methods
function manager() {
    let manager = new Worker("Alice", 30, 120, 100, 30);
    manager.doSomethingFun(); //Run the doSomethingFun() method on the manager object. 
    return manager; //return the manager object.
}