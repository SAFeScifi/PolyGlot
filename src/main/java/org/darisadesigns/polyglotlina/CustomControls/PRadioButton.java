/*
 * Copyright (c) 2016-2019, Draque Thompson
 * All rights reserved.
 *
 * Licensed under: Creative Commons Attribution-NonCommercial 4.0 International Public License
 *  See LICENSE.TXT included with this code to read the full license agreement.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.darisadesigns.polyglotlina.CustomControls;

import java.awt.Font;
import org.darisadesigns.polyglotlina.IOHandler;
import org.darisadesigns.polyglotlina.Nodes.ConWord;
import org.darisadesigns.polyglotlina.Nodes.DictNode;
import org.darisadesigns.polyglotlina.QuizEngine.QuizQuestion.QuestionType;
import javax.swing.JRadioButton;
import org.darisadesigns.polyglotlina.PGTUtil;

/**
 * 
 * @author draque.thompson
 */
public final class PRadioButton extends JRadioButton {
    private DictNode value = null;
    private QuestionType type;
    private final Font conFont;
    private final double menuFontSize;
    private final boolean nightMode;

    public PRadioButton(Font _conFont, double _menuFontSize, boolean _nightMode) { // nightmode left for future enhancements
        conFont = _conFont;
        menuFontSize = _menuFontSize;
        nightMode = _nightMode;
        this.setFont(PGTUtil.MENU_FONT.deriveFont((float)menuFontSize));
    }
    
    /**
     * @return the value
     */
    public DictNode getValue() {
        return value;
    }

    /**
     * @param _value the value to set
     */
    public void setValue(DictNode _value) {
        this.value = _value;
    }
    
    @Override
    public String getText() {
        String ret = super.getText();
        
        if (!(type == null || value == null)) {
            switch (type) {
                case ConEquiv:
                    setFont(conFont);
                case PoS:
                case Classes:
                    ret = value.getValue();
                    break;
                case Local:
                    ret = ((ConWord)value).getLocalWord();
                    break;
                case Proc:
                    try {
                        ret = ((ConWord)value).getPronunciation();
                    } catch (Exception e) {
                        IOHandler.writeErrorLog(e);
                        ret = "<ERROR>";
                    }
                    break;
                case Def:
                    ret = ((ConWord)value).getDefinition();
                    break;
                default:
                    ret = "UNHANDLED TYPE";
            }
        }
        
        return ret;
    }

    /**
     * @param _type the type to set
     */
    public void setType(QuestionType _type) {
        this.type = _type;
    }
}