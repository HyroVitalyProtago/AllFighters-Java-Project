-- AllFighters

--GITHUB = "https://raw.github.com/"
--ALL_FIGHTERS = "HyroVitalyProtago/AllFighters/master/"
SPRITES = "SpriteAllFighters/"
TAKESHI_YAMAMOTO = "TakeshiYamamoto/"

SPRITES_LOCATION = "Dropbox:" .. SPRITES

function setup()
    
    displayMode(FULLSCREEN_NO_BUTTONS)
    
    parameter.boolean("SHOW_SNAP", false)
    parameter.boolean("SHOW_BOXS", true)
    parameter.boolean("SHOW_BOXS_FIGHTER", false)
    parameter.boolean("DEV_SPRITE", false)
    parameter.number("scal", 0, 5, 1)
    
    game = Game()
    mkeyboard = Keyboard()
    MakeTakeshiYamamoto.run()
    -- showKeyboard()
end

function draw()
    background(0, 0, 0, 255)
    font("AmericanTypewriter")
    spriteMode(CORNER)
    noFill()
    strokeWidth(2)
    smooth()
    
    scale(scal)
    if MakeTakeshiYamamoto.isLoaded then
        game:draw()
        mkeyboard:draw()
    else
        --sprite("Documents:Background")
        fill(255, 255, 255, 255)
        fontSize(50)
        txt = "Loading"
        local w, h = textSize(txt)
        text(txt .. "...", WIDTH/2, HEIGHT/2)
    end
end

function touched(touch)
    local key = mkeyboard:touched(touch)
    if not (key == nil) then
        keyboard(key)
    end
end

function keyboard(key)
    game:keyboard(key)
end