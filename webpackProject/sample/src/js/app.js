import { RandomGenerator } from "./random-generator";
import '../css/main.scss'

var button1 = document.querySelector("#randomInt");
var button2 = documnet.querySelector("#randomRange");
var para = document.querySelector("outputPara");

const getRandomInt = () => {
    para.textContent = RandomGenerator.randomInteger();
}

const getRandomRange = () => {
    para.textContent = RandomGenerator.randomRange(1, 500);
}

button1.addEventListener('click', getRandomInt);
button2.addEventListener('click', getRandomRange);