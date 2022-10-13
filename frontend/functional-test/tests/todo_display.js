const { openBrowser, closeBrowser, text, textBox, goto, into, write, press, checkBox, clear } = require('taiko');
const assert = require("assert");
'use strict';

const headless = process.env.headless_chrome.toLowerCase() === 'true';

beforeSuite(async () => {
    await openBrowser({
        headless: headless
    })
});

afterSuite(async () => {
    await closeBrowser();
});

step("Go to My Todos homepage", async () => {
    await goto("http://localhost:3000");
});

step("Write <test_title> into title field", async (test_title) => {
    await write(test_title, into(textBox({class:"title-field"})));
});

step("Click <button_title> button", async (button_title) => {
    // await click(button_title, { navigationTimeout: 1000 });
    await press("Enter")
    await clear(textBox({class:"title-field"}));
    
});

step("Verify <todo_title> exists", async (todo_title) => {
    assert.ok(await text(todo_title).exists())
})
