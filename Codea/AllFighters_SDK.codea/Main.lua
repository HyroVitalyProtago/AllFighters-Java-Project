-- AllFighters_SDK

supportedOrientations(LANDSCAPE_ANY)
supportedOrientations(CurrentOrientation)
displayMode(FULLSCREEN)
--displayMode(FULLSCREEN_NO_BUTTONS)

function setup()
    --manager = Manager(Screen_MainMenu())
    manager = Manager(Screen_Fighter({name="Takeshi Yamamoto"}))
end

function draw()
    manager:draw()
end

function touched(touch)
    manager:touched(touch)
end