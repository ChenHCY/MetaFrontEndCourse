// Task 1
var dairy = ['cheese', 'sour cream', 'milk', 'yogurt', 'ice cream', 'milkshake']

function logDairy(){
    for (let item of dairy){
        console.log(item);
    }
}

// Task 2
const animal = {
    canJump: true
};

const bird = Object.create(animal);
bird.canFly = true;
bird.hasFeathers = true;

function birdCan() {
    for (let propItem of Object.keys(bird)) {
        console.log(propItem + ": " + bird[propItem]);
    }
}

// Task 3
function animalCan(){
    for (let propItem of Object.keys(bird)) {
        console.log(propItem + ": " + bird[propItem]);
    }

    for (let propItem of Object.keys(animal)) {
        console.log(propItem + ": " + animal[propItem]);
    }
}

//call the function to output
logDairy();
birdCan();
animalCan();